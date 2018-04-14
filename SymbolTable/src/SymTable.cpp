#include "SymTable.h"

struct HashNode
{
    HashNode *next =NULL;
    int blknumber =0;
    pair<int,int> id = {-1,-1};
};

SymTable::SymTable()
{}

int SymTable::HashFunc(string str)
{
    int sum =0;
    int i =0;

    while (str[i] != '\0')
    {
        sum+= int(str[i]);
        i++;
    }

    return sum%5;
}

pair<int,int> SymTable::StringNum(string str)
{
    pair<int,int> strNum = {posPtr,str.length()};
    posPtr+=str.length();
    ssa+=str;
    cout<<"String Space Array: "<<ssa<<endl;

    return strNum;
}

void SymTable::FindAll(string str)
{
    pair<int,int> strNum = {0,0};
    int key =HashFunc(str);
    HashNode* currptr= symbolTable[key];
    size_t found =ssa.find(str);

    if(found!=string::npos)
    {
        strNum = {found, str.length()};
        while(currptr)
        {
            if(currptr->id== strNum)
            {
                cout<<"found it!"<<endl;
                return;
            }
            else cout<<"not found!"<<endl;
        }
    }

}

HashNode* SymTable::FindCur(string str, int b_num)
{
    pair<int,int> strNum = {0,0};
    int key =HashFunc(str);
    HashNode* currptr= symbolTable[key];
    size_t found =ssa.find(str);

    if(found!=string::npos)
    {
        strNum = {found, str.length()};
        while(currptr)
        {
            if((currptr->blknumber == b_num)&& (currptr->id== strNum))
            {
                cout<<str <<" :found in Symbol Table!"<<endl;
                return currptr;
            }
            else currptr = currptr->next;
        }
    }
    return NULL;
}

void SymTable::Insert(string str, int b_num)
{
    pair<int,int> strNum = StringNum(str);
    HashNode* head= symbolTable[HashFunc(str)];
    HashNode* newNode = new HashNode;
    newNode->blknumber = b_num;
    newNode->id = strNum;

    if(head)
    {
        newNode->next= head;
        symbolTable[HashFunc(str)] = newNode;
    }
    else  symbolTable[HashFunc(str)] = newNode;
}

void SymTable::Display()
{
    cout<<"************ Symbol Table **************"<<endl;
    for(int i =0; i<symbolTable.size(); i++)
    {
        HashNode* nodePtr= symbolTable[i];
        cout<<"["<<i<<"]";
        while(nodePtr)
        {
            cout<<" -> "<< "("<<nodePtr->id.first<<","<<nodePtr->id.second<<","<< nodePtr->blknumber<<")";
            nodePtr = nodePtr->next;
        }
        cout<<'\n';

    }
    cout<<'\n';
    cout<<"String Space Array: "<<ssa<<endl;
}
