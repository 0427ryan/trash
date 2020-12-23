#include "deck.h"

Deck::Deck() {
    this->last = 51;
    this->cards.resize(52, nullptr);
    for(int i = 0 ; i < 4 ; i++) {
        for(int j = 1 ; j <= 13 ; j++) {
            this->cards[ i * 13 + j - 1] = new Card(Kind(i), Num(j));
        }
    }
}

Deck::~Deck() {
    for(int i = 0 ; cards[i] != nullptr ; i++) {
        delete cards[i];
    }
}

void Deck::shuffle() {
    srand(time(NULL));
    std::random_shuffle(std::begin(cards), std::begin(cards) + last + 1,
        [](int max){ return rand() % max; } );
}

Card *Deck::getFirst() {
    if(last >= 0) {
        Card *c = cards[last];
        cards[last] = nullptr;
        this->last = this->last - 1;
        return c;
    }
    std::cout << "error";
    return nullptr;
}