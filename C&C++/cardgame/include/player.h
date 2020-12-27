#pragma once

class Player;

#include "deck.h"
#include "cardgame.h"
#include <vector>

class Player {
    
    const std::string name = "";
    std::vector<Card *> holdedCards;
    CardGame *nowPlaying = nullptr;
    int sum = 0;

public:
    Player() = default;
    Player(std::string);
    ~Player();

    bool addGame(CardGame *);
    bool removeGame(CardGame *);
    
    void addCard(Card*);
    std::string getName() const ;
    void setSum(int);
    int getSum() const ;

    void clearCards();

    std::string tostring() const ;
};