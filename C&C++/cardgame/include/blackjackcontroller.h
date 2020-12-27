#pragma once

#include "player.h"
#include "cardgame.h"
#include <iostream>

// this doesn't provide no-argument constructor.
class BlackJackController {
    CardGame* game;
public:
    BlackJackController(CardGame *);
    ~BlackJackController(){};

    void playerAddCard(Player *p);
    int dealWithOne(Player *p);

    inline void run() {
        if( !checkOK() ) {
            return;
        }
        init();
        firstRoundTakeCard();
        guestTakeCard();
        hostTakeCard();
        everyoneShowCard();
        showResult();
        return;
    }
    bool checkOK();
    void init();
    void firstRoundTakeCard();
    void guestTakeCard();
    void hostTakeCard();
    void everyoneShowCard();
    void showResult();
};