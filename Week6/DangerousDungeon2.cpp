#include <iostream>
#include <queue>
#include <stack>
#include <vector>
using namespace std; 

typedef struct pathXY {
    int x;
    int y;
}pathXY;

typedef struct field{
    char character;
    int x, y, z, step;
    vector<pathXY> pathXY;
}field;

int w,l,d;
int targetX,targety,targetZ;
int mins = 9999999;
field *target;
bool exit(int x,int y,int z){
    if (x >= 0 && x < w && y >= 0 && y < l && z > 0 && z <= d) {
        return true;
    }
    return false;
}

void other(field cave[][100],queue<field> &q, int x, int y,int z,double step,field current)
{
    if (exit(x, y, z)) {
        y = y + (z - 1) * l;
        if (cave[y][x].character != 'O' && cave[y][x].character != 'A');
        else {
            if (cave[y][x].character == 'A') {
                target = &cave[y][x];
                targetX = x;
                targety = y;
            }
            field *temp = &cave[y][x];
            temp->x = x;
            temp->y = y - (z-1) * l;
            temp->z = z;
            temp->step = current.step + 1;
            if (temp->step < mins) {
                mins = temp->step;
            }
            temp->character = 'G';
            q.push(*temp);
        }
    }
}

void BFS(field cave[][100],int x,int y ,int z){
    queue<field> queueField;
    field *start = &cave[y + (z - 1) * l][x];
    start->x = x;
    start->y = y;
    start->z = z;
    start->step = 0;
    start->character = 'G';
    queueField.push(*start);
    while (!queueField.empty()) {
        field start = queueField.front();
        queueField.pop();
        other(cave,queueField,(start.x) - 1,(start.y) - 1,(start.z),start.step,start);
        other(cave,queueField,(start.x),(start.y) - 1,(start.z),start.step,start); 
        other(cave,queueField,(start.x) + 1,(start.y) -1,(start.z),start.step,start);
        other(cave,queueField,(start.x) -1,(start.y),(start.z),start.step,start);            
        other(cave,queueField,(start.x) + 1,(start.y),(start.z),start.step,start);
        other(cave,queueField,(start.x) - 1,(start.y) + 1,(start.z),start.step,start);
        other(cave,queueField,(start.x),(start.y) + 1,(start.z),start.step,start);
        other(cave,queueField,(start.x) + 1,(start.y) + 1,(start.z),start.step,start); 
        other(cave,queueField,(start.x),(start.y),(start.z) + 1,start.step,start);
        other(cave,queueField,(start.x),(start.y),(start.z) -1,start.step,start);
    }
}

void otherDFS(vector<pathXY> &shortestPath,field cave[][100], stack<field> &s, int x, int y,int z,double step,field current)
{
    if (exit(x, y, z)) {
        y = y + (z - 1) * l;
        if (cave[y][x].step == 0) {
            pathXY ptemp;
            ptemp.x = x;
            ptemp.y = y;
            (current.pathXY).push_back(ptemp);
            shortestPath.insert(shortestPath.end(),current.pathXY.begin(),(current.pathXY).end());
        }
        else if ((current.step - cave[y][x].step) == 1) {
            pathXY ptemp;
            ptemp.x = x;
            ptemp.y = y;
            (cave[y][x].pathXY).push_back(ptemp);
            (cave[y][x].pathXY).insert((cave[y][x].pathXY).end(),(current.pathXY).begin(),(current.pathXY).end());
            field *temp = &cave[y][x];
            s.push(*temp);
        }
    }
}

vector<pathXY> DFS(field cave[][100],field *target,int x,int y,int z) {
    stack<field> stack;
    vector<pathXY> shortestPath;
    pathXY temp;
    temp.x = targetX;
    temp.y = targety;
    (target->pathXY).push_back(temp);
    stack.push(*target);
    while (!stack.empty()) {
        field start = stack.top();
        stack.pop();
        otherDFS(shortestPath,cave,stack,(start.x) - 1,(start.y) - 1,(start.z),start.step,start);
        otherDFS(shortestPath,cave,stack,(start.x),(start.y) - 1,(start.z),start.step,start);  
        otherDFS(shortestPath,cave,stack,(start.x) + 1,(start.y) -1,(start.z),start.step,start);
        otherDFS(shortestPath,cave,stack,(start.x) -1,(start.y),(start.z),start.step,start);            
        otherDFS(shortestPath,cave,stack,(start.x) + 1,(start.y),(start.z),start.step,start);
        otherDFS(shortestPath,cave,stack,(start.x) - 1,(start.y) + 1,(start.z),start.step,start);
        otherDFS(shortestPath,cave,stack,(start.x),(start.y) + 1,(start.z),start.step,start);
        otherDFS(shortestPath,cave,stack,(start.x) + 1,(start.y) + 1,(start.z),start.step,start);    
        otherDFS(shortestPath,cave,stack,(start.x),(start.y),(start.z) + 1,start.step,start);
        otherDFS(shortestPath,cave,stack,(start.x),(start.y),(start.z) -1,start.step,start);   
    }
    return shortestPath;
}

int main() {
    int x,y,z;
    field cave[100][100];
    field result[100][100];
    cin >> w >> l >> d;
    cin >> x >> y >> z;

    for (int i = 0; i < l*d;i++) {
        string temp;
        cin >> temp;
        for (int j = 0; j < w ; j++) {
            cave[i][j].character = temp[j];
            cave[i][j].x = j;
            cave[i][j].y = i;
            cave[i][j].z = 0;
            cave[i][j].step = -1;
            result[i][j].character = temp[j];
        }
    }

    BFS(cave,x-1,y-1,z);
    vector<pathXY>shortestPath = DFS(cave,target,x-1,y-1,z);
    for (int i = 0; i < l*d;i++) {
        for (int j = 0; j < w ; j++) {
            bool check = false;
            for (auto p:shortestPath){
                if (result[i][j].character == 'O' && (i == p.y && j == p.x)) {
                    cout <<"G";
                    check = true;
                    break;
                }
            }
            if (!check) {
                cout << result[i][j].character;
            }
        }
        cout << endl;
    }
}
