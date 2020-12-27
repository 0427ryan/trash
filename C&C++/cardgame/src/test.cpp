#include <iostream>
#include "blackjackcontroller.h"
using namespace std;

int main() {
    Player *p1 = new Player("p1");
    Player *p2 = new Player("p2");
    Player *p3 = new Player("p3");

    Player *host = new Player("host");
    
    CardGame *cg = new CardGame(4, host, {p1, p2, p3});
    
    BlackJackController *game = new BlackJackController(cg);

    game->run();

    delete p1;
    delete p2;
    delete p3;
    delete host;
    delete cg;
    delete game;
}