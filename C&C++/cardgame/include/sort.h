#ifndef MY_SORT
#define MY_SORT 123

template<typename T>
void swap(T *a, T *b);

template<typename T>
bool compare(T a, T b);

template<typename T>
void sort(T* begin, T* end);

template<typename T>
void sort(T* begin, T* end, bool (*compare)(T, T));


#endif