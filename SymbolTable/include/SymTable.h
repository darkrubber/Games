#ifndef SYMTABLE_H
#define SYMTABLE_H
#include <string>
#include <iostream>
#include <unordered_map>
using namespace std;

struct HashNode;

class SymTable
{
    public:
        SymTable();
        HashNode* FindCur(string, int);
        void FindAll(string);
        void Insert(string, int);
        void Display();

    private:
        string ssa ="";           //String space array
        int posPtr = 0;
        pair<int,int> StringNum(string);
        int HashFunc(string str);
        unordered_map<int, HashNode*> symbolTable;
};

#endif // SYMTABLE_H
