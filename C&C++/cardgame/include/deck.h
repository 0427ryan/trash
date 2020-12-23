#pragma once

#include "card.h"
#include <vector>
#include <algorithm>
#include <ctime>
#include <random>
class Deck {
    
    int last = 0;
    std::vector<Card *> cards;

public:

    Deck();
    ~Deck();

    void shuffle();
    Card *getFirst();
};