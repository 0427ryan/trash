#include"sort.h"
#include<iostream>
template<typename T>
void swap(T *a, T *b) {
    T temp = *a;
    *a = *b;
    *b = temp;
    return;
}

template<typename T>
bool compare(T a,T b){
    return a > b;
}
void sort(int* begin, int* end){
    sort(begin, end, compare);
}
template<typename T>
void sort(T* begin, T* end){
    sort(begin, end, compare);
}

template<typename T>
void sort(T* begin, T* end, bool (*compare)(T, T)){
    if( begin >= end - 1 ){
        return;
    }
    std::cout << end - begin << std::endl;
    T* i = begin;
    T* j = end;
    while(i != j){
        if(!compare(*i, *(i + 1) )){
            swap(i, j);
            j--;
        }
        else{
            swap(j, (i + 1));
            i++;
        }
    }
    sort(begin, i, compare);
    sort(i+1, end, compare);
    return;
}

