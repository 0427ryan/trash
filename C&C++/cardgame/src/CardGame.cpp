#include "cardgame.h"

CardGame::CardGame(Player *host, std::initializer_list<Player *> players):
    maxPlayerNumber(4) {
    this->changeHost(host);
    this->addGuest(players);
}
CardGame::CardGame(const int max, Player *host, std::initializer_list<Player *> players):
    maxPlayerNumber(max) {

    this->changeHost(host);
    this->addGuest(players);
}
CardGame::~CardGame() {
    delete this->cards;
}

bool CardGame::contains(Player *player) {
    if(host == player) {
        return true;
    }
    for(Player *p : this->guestPlayers) {
        if(p == player) {
            return true;
        }
    }
    return false;
}

void CardGame::changeHost(Player *host) {
    if(this->host != nullptr) {
        this->host->removeGame(this);
    }
    this->host = host;
    host->addGame(this);
}

void CardGame::addGuest(std::initializer_list<Player *> guestPlayers) {
    for(Player *p : this->guestPlayers) {
        this->addGuest(p);
    }
}
void CardGame::addGuest(Player *player) {
    //check wheater the player can be apply, if not, enter the block(return).
    if( this->contains(player) ||
            this->getPlayerNumber() == maxPlayerNumber ||
            player == nullptr) {
        return;
    }
    this->guestPlayers.push_back(player);
    player->addGame(this);
    return;
}

void CardGame::removeGuest(std::initializer_list<Player *> guestPlayers) {
    for(Player *p : this->guestPlayers) {
        this->removeGuest(p);
    }
}

void CardGame::removeGuest(Player *guestPlayer) {
    for(int i = 0 ; i < guestPlayers.size() ; i++) {
        if( this->guestPlayers[i] == guestPlayer ) {
            this->guestPlayers.erase(this->guestPlayers.begin() + i);
            guestPlayer->removeGame(this);
            return;
        }
    }
}

void CardGame::refreshCards() {
    if(this->cards != nullptr) {
        delete cards;
    }
    cards = new Deck();
}

int CardGame::getPlayerNumber() {
    return guestPlayers.size() + (host == nullptr ? 0 : 1);
}

Deck *CardGame::getCards() {
    return cards;
}

Player *CardGame::getHost() {
    return host;
}

std::vector<Player*> CardGame::getGuestPlayers() {
    return this->guestPlayers;
}