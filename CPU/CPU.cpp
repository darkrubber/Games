#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <unistd.h>
using namespace std;

// RAM (divided into 3 sections)
int ram_op[5];
int ram_in[5];
int ram_addr[5];

// IR
int opcode =0;
int addr = 0;

int mar = 0;

//MBR
int mbr_op = 0;
int mbr_addr = 0;


int pc = 0 ;
int f,r,i,ac =0;
int indir = 0;

enum inst {AND,ADD,LDA,STA,BUN,BSA,ISZ};
// convert them into numerical representation

void fetch(){
    usleep(100);
    mar = pc;

    usleep(100);
    mbr_op = ram_op[mar];
    mbr_addr = ram_addr[mar];
    indir = ram_in[mar];
    pc+=1;

    usleep(100);
    opcode = mbr_op;
    addr = mbr_addr;
    i = indir;

    usleep(100);
    if(i == 1)
        r =1;
    else f = 1;

}

void indirect(){
    usleep(100);
    mar = mbr_addr;

    usleep(100);
    mbr_op = ram_op[mar];
    mbr_addr = ram_addr[mar];
    indir = ram_in[mar];

    usleep(200);

    usleep(100);
    f= 1;
    r= 0;
}

void iand(){
    usleep(100);
    mar = mbr_addr;

    usleep(100);
    mbr_op = ram_op[mar];
    mbr_addr = ram_addr[mar];
    indir = ram_in[mar];

    usleep(100);
    ac &=(mbr_addr + mbr_op);

    usleep(100);
    f= 0;
}

void iadd(){
    usleep(100);
    mar = mbr_addr;

    usleep(100);
    mbr_op = ram_op[mar];
    mbr_addr = ram_addr[mar];
    indir = ram_in[mar];

    usleep(100);
    ac+=(mbr_addr + mbr_op);

    usleep(100);
    f= 0;
}
void lda(){

    usleep(100);
    mar = mbr_addr;

    usleep(100);
    mbr_op = ram_op[mar];
    mbr_addr = ram_addr[mar];
    indir = ram_in[mar];

    usleep(100);
    ac =(mbr_addr + mbr_op);

    usleep(100);
    f= 0;
}

void sta(){
    usleep(100);
    mar = mbr_addr;

    usleep(100);
    mbr_op = ram_op[mar];
    mbr_addr = ram_addr[mar];
    indir = ram_in[mar];

    usleep(100);
    mbr_addr = ac;
    mbr_op = ac;

    usleep(100);
    f= 0;
}

void bun(){
    usleep(100);
    pc = (mbr_addr+ mbr_op);

    usleep(200);

    usleep(200);

    usleep(100);
    f= 0;
}

void bsa(){
    int temp = 0;
    usleep(100);
    mar = mbr_addr;
    temp = mbr_addr;
    mbr_addr = pc;
    pc= temp;

    usleep(100);
    ram_op[mar] = mbr_op;
    ram_addr[mar] = mbr_addr;
    ram_in[mar] = indir;

    usleep(100);
    pc+=1;

    usleep(100);
    f= 0;
}

void isz(){

    usleep(100);
    mar = mbr_addr;

    usleep(100);
    mbr_op = ram_op[mar];
    mbr_addr = ram_addr[mar];
    indir = ram_in[mar];

    usleep(100);
    mbr_addr += 1;

    usleep(100);
    ram_op[mar] = mbr_op;
    ram_addr[mar] = mbr_addr;
    ram_in[mar] = indir;
    if(mbr_addr==0)
        pc +=1;
    f= 0;
}


int main(){

    ifstream infile("inst.txt");
    string s;

    // using decimal numbers for the opcode and the address
    while(getline(infile, s)){
    stringstream ss(s);
    ss>>ram_in[i];
    ss>>ram_op[i];
    ss>>ram_addr[i];
    i++;
    }

    while (pc <= (sizeof(ram_op)/sizeof(ram_op[0]))){

    if((r==0)&& (f==0))
        fetch();

    if((r==1)&&(f==0))
        indirect();

    if((f==1)&& (r==0)){
        switch(opcode){
            case AND: iand();break;
            case ADD: iadd();break;
            case LDA: lda();break;
            case STA: sta();break;
            case BUN: bun();break;
            case BSA: bsa();break;
            case ISZ: isz();break;
        }
        }

        cout<<"AC: "<<ac<<endl;
        cout<<"I:" <<i<<" OP:"<<opcode<<endl;
        cout<<"==========="<<endl;
    }

    for(i=0; i <5;i++){
        cout<<ram_in[i]<<" "<<ram_op[i]<<" "<< ram_addr[i]<<endl;
    }

    return 0;
}
