#include "player.h"

Player::Player(std::string name): name(name){};
Player::~Player() {
    this->clearCards();
}

bool Player::addGame(CardGame *game) {
    if( this->nowPlaying == nullptr && game->contains(this)) {
        //check
        this->nowPlaying = game;
        return true;
    }
    return false;
}
bool Player::removeGame(CardGame *game) {
    /*
        this will check game played is or isn't the game put in,
        if it is, remove that and return true,
        else, do nothing and retuen false.
    */
    if( this->nowPlaying == game ) {
        nowPlaying = nullptr;
        return true;
    }
    return false;
}

inline void Player::addCard(Card *c) {
    /*
        this is is used to add new card.
    */
    if(this->nowPlaying != nullptr && c != nullptr) {
        holdedCards.push_back(c);
    }
}

inline std::string Player::getName() const {
    return this->name;
}

inline void Player::setSum(int sum) {
    this->sum = sum;
}

inline int Player::getSum() const {
    return sum;
}

void Player::clearCards() {
    for(Card *c : this->holdedCards) {
        if( c != nullptr ) {
            delete c;
        }
    }
    this->sum = 0;
}

inline std::string Player::tostring() const {
    std::string ret = this->name;

    for(Card *c : holdedCards) {
        ret = ret + "\n\t" + c->tostring();
    }

    return ret;
}