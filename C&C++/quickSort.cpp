#include<iostream>

template<typename T>
bool minorder(T a, T b){
	return a<b;
}
template<typename T>
void swap(T *a, T *b){
	T temp = *a;
	*a = *b;
	*b = temp;
}
template<typename T>
void quickSort(T *begin, T *end, bool (*f)(T ,T) = minorder){
	if(begin >= end - 1){
		return;
	}
	T *mid = begin;
	T *i = begin + 1, *j = end - 1;
	while(i != j){
		if( f(*i, *mid) ){
			swap(mid, i);
			i++;
			mid++;
		}else{
			swap(i, j);
			j--;
		}
	}
	if( !f(*mid, *i)){
		swap(mid, i);
		i++;
	}
	quickSort(begin, (i - 1),f);
	quickSort(i, end, f);
}
int main(){
	char a[] = "061324";
	quickSort(a,a+6);
	for (auto i : a){
		std::cout<<i<<' ';
	}
}