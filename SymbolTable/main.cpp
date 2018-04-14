// ST
// Eugene Leung

#include <iostream>
#include <string>
#include <stack>
#include <fstream>
#include <sstream>
#include <cstring>
#include <stdlib.h>
#include <SymTable.h>
#include <vector>

using namespace std;

void showstack(stack <int> as)
{
    stack<int> s = as;
    if(as.empty())
        return;
    cout<<"======== Stack of Active Block========"<<endl;
    while (!s.empty())
    {

        cout << '\t' << s.top()<<endl;;
        s.pop();
    }
    cout<<"====================================="<<endl;

}

int main(int argc, char *argv[])
{
    stack<int> activeST;

    ifstream inFile("example.txt");
    int block_num =0;
    HashNode *curr;
    SymTable st;
    char ch;         // read file character by character
    string str ="";

    if (!inFile)
    {
        cerr << "File " << argv[1] << " could not be opened" << endl;
        exit(1);
    }

    while(inFile>> noskipws>> ch)
    {
        if(ch=='{')
        {
            block_num++;
            activeST.push(block_num);
            showstack(activeST);

        }
        else if(ch =='}')
        {
            activeST.pop();
            showstack(activeST);
        }
        else if(ch ==' '|| ch =='\n'|| ch=='	')
        {
            if(str!="")
            {
                curr = st.FindCur(str,activeST.top());
                if(!curr)
                {
                    st.Insert(str,activeST.top());
                    st.FindAll(str);
                }
            }
            str="";
        }
        else  str +=ch;
    } // while

    st.Display();
    inFile.close();
    return 0;
}
