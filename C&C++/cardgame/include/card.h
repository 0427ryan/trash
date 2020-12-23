#pragma once

#include <string>
#include <iostream>

enum Num : int {
    Ace = 1, Two, Three,
    Four, Five, Six,
    Seven, Eight, Nine, Ten,
    Jack, Queen, King
};

enum Kind : int {
    Spade,
    Diamond,
    Heart,
    Club
};

namespace my_util {

    template<class T>
    inline std::string toString(T t){
        return t.tostring();
    }

    template<>
    std::string toString(Num);

    template<>
    std::string toString(Kind);

}

class Card {
    const Kind kind;
    const Num num;

    void operator=(Card &){ };

public:

    Card(Kind, Num);

    Card(const Card &c);

    const Kind getKind() const { return kind; };
    const Num getNum() const { return num; };

    std::string tostring() const ;

    inline int getPriority() const;

    inline bool operator>(Card &) const;
    inline bool operator<(Card &) const;
    inline bool operator==(Card &) const;

    inline bool operator>=(Card &) const;
    inline bool operator<=(Card &) const;
    inline bool operator!=(Card &) const;
};

std::ostream &operator<<(std::ostream &o, Card &c);

