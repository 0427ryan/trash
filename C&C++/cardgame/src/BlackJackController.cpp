#include "blackjackcontroller.h"

BlackJackController::BlackJackController(CardGame *game):
    game(game) { }

void BlackJackController::playerAddCard(Player *p) {
    /* give player card and add it to sum,
       if meet number bigger than 10, this will make player's sum added 10,
       if meet Ace, this will call the function dealWithOne.
    */
    Card *card = game->getCards()->getFirst();
    p->addCard(card);
    std::cout << p->getName() << " gets " << (*card) << std::endl;

    if( card->getNum() >= Ten ) {
        p->setSum( p->getSum() + 10 );
        return;
    }
    if(card->getNum() == Ace ) {
        p->setSum( p->getSum() + this->dealWithOne(p) );
        return;
    }
    p->setSum( p->getSum() + int( card->getNum() ) );
}

int BlackJackController::dealWithOne(Player *p) {
    /*
        deal with Ace,
        this while ask the player who got an Ace use one or eleven
        to be the number represent the card then return the number player chose
    */
    int sum = 0;
    std::cout << p->getName() << std::endl
              << "This is Ace, choose 1 or 11" << std::endl;
    while(true) {
        std::cin >> sum;
        if(sum != 1 && sum != 11) {
            std::cout << "Please enter 1 or 11." << std::endl;
            continue;
        }
        return sum;
    }
}

bool BlackJackController::checkOK() {
    /*
        check if host existed.
    */
    if(game->getHost() == nullptr) {
        return false;
    }
    return true;
}

void BlackJackController::init() {
    /*
        call cardgame to prepare cards, suffle,
        and clear players and host's cards,
    */
    game->refreshCards();

    game->getCards()->shuffle();

    for(Player *p : game->getGuestPlayers()) {
        p->clearCards();
    }
    game->getHost()->clearCards();
}

void BlackJackController::firstRoundTakeCard() {
    /*
        host takes one card, then each plaayers takes two cards
    */
    playerAddCard(game->getHost());

    std::cout << game->getHost()->tostring() << std::endl;

    for(Player *p : game->getGuestPlayers()) {
        playerAddCard(p);
        playerAddCard(p);
        std::cout << p->tostring() << std::endl;
    }

    std::cout << std::endl;
}

void BlackJackController::guestTakeCard() {

    /*
        each guests chose whather to take card,
        if the sum of cards overflow, this won't ask, will exit.

    */

    for(Player* p : game->getGuestPlayers()) {

        std::cout << p->getName() << " sum: " << p->getSum() << std::endl
                << p->getName() << " Add card? (y/n) " << std::endl;
        std::string s;
        std::cin >> s;
        while( p->getSum() <= 21 && s == "y" ) {

            playerAddCard(p);

            std::cout << p->getName() << " sum: " << p->getSum() << std::endl;
            if(p->getSum() <= 21) {
                std::cout << p->getName() << " Add card? (y/n) " << std::endl;
                std::cin >> s;
            }
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
}

void BlackJackController::hostTakeCard() {

    /*
        ask host to take card, if the sum larger than 21 this won't ask,
        will exit.
    */

    Player *host = game->getHost();

    std::cout << host->getName() << " sum: " << host->getSum() << std::endl;
    std::cout << host->getName() << " Add card? (y/n) ";

    std::string s;
    std::cin >> s;
    while( host->getSum() <= 21 && s == "y" ) {
        playerAddCard(host);

        std::cout << host->getName() << " sum: " << host->getSum() << std::endl;
        if(host->getSum() <= 21) {
            std::cout << host->getName() << " Add card? (y/n) " << std::endl;
            std::cin >> s;
        }
    }
    std::cout << std::endl;
}

void BlackJackController::everyoneShowCard() {
    /*
        show players and host's detail.
    */
    std::cout << game->getHost()->tostring();
    for(Player *p : game->getGuestPlayers() ) {
        std::cout << p->tostring();
    }

    std::cout << std::endl;
}

void BlackJackController::showResult() {

    /*
        judge everyone is or isn't win, then show it.
    */

    Player *host = game->getHost();
    for(Player *p : game->getGuestPlayers()) {

        std::cout << p->getName() << " sum = " << p->getSum() << std::endl;
        if(  p->getSum() <= 21 &&
                (host->getSum() > 21 || p->getSum() > host->getSum()) ) {

            std::cout << p->getName() << " Win" << std::endl;
        } else {
            std::cout << p->getName() << " Lose" << std::endl;
        }

    }

}
