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
    
    inline void addCard(Card*);
    inline std::string getName() const ;
    inline void setSum(int);
    inline int getSum() const ;

    void clearCards();

    inline std::string tostring() const ;
};