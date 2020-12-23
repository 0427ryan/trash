#pragma once

class CardGame;

#include "player.h"
#include "deck.h"
#include <vector>
#include <initializer_list>

class CardGame {

    const int maxPlayerNumber = 4;
    Player *host = nullptr;
    std::vector<Player *> guestPlayers;
    Deck *cards = nullptr;

public:
    CardGame() = default;
    CardGame(Player *, std::initializer_list<Player *>);
    CardGame(const int, Player *, std::initializer_list<Player *>);
    ~CardGame();

    bool contains(Player *);

    void changeHost(Player *) ;

    inline void addGuest(std::initializer_list<Player *>) ;
    void addGuest(Player *player);

    inline void removeGuest(std::initializer_list<Player *> guestPlayers);

    void removeGuest(Player *guestPlayer) ;

    inline void refreshCards() ;

    inline int getPlayerNumber();

    inline Deck *getCards();

    inline Player *getHost();
    inline std::vector<Player*> getGuestPlayers();
};