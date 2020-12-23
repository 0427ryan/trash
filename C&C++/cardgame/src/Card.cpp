#include "card.h"

namespace my_util {

    template<>
    std::string toString(Num n) {
        switch(n) {
        case Ace:
            return "Ace";
        case Two:
            return "Two";
        case Three:
            return "Three";
        case Four:
            return "Four";
        case Five:
            return "Five";
        case Six:
            return "Six";
        case Seven:
            return "Seven";
        case Eight:
            return "Eight";
        case Nine:
            return "Nine";
        case Ten:
            return "Ten";
        case Jack:
            return "Jack";
        case Queen:
            return "Queen";
        case King:
            return "King";
        }
        return "Error";
    };

    template<>
    std::string toString(Kind k) {
        switch(k) {
        case Spade:
            return "Spade";
        case Diamond:
            return "Diamond";
        case Heart:
            return "Heart";
        case Club:
            return "Club";
        }
        return "Error";
    }
}

Card::Card(Kind kind, Num num):
    kind(kind), num(num) {
}

Card::Card(const Card &c):
    kind(c.getKind()), num(c.getNum()) { }

inline std::string Card::tostring() const {
    return "Kind : " + my_util::toString(this->kind)
           + " Num : " + my_util::toString(this->num );
}

inline int Card::getPriority() const {
    return num * 13 + kind;
}

inline bool Card::operator>(Card &c) const {
    return this->getPriority() > c.getPriority();
}
inline bool Card::operator<(Card &c) const {
    return this->getPriority() < c.getPriority();
}
inline bool Card::operator==(Card &c) const {
    return this->getPriority() == c.getPriority();
}

inline bool Card::operator>=(Card &c) const {
    return this->getPriority() >= c.getPriority();
}
inline bool Card::operator<=(Card &c) const {
    return this->getPriority() <= c.getPriority();
}
inline bool Card::operator!=(Card &c) const {
    return this->getPriority() != c.getPriority();
}


std::ostream &operator<<(std::ostream &o, Card &c) {
    return o << c.tostring();
}