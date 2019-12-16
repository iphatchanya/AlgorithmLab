#include <iostream>
#include <queue>
 
using namespace std;
 
typedef struct pos {
    int x, y, t;
} pos;
 
bool check_pos(int height, int width, int x, int y, int t, string map[], queue<pos> &q) {
    if (x >= 0 && y >= 0 && x < height && y < width) {
        if (map[x][y] == 'B') {
            return true;
        } else {
            if (map[x][y] == 'N') {
                pos p;
                p.x = x;
                p.y = y;
                p.t = ++t;
                q.push(p);
                map[x][y] = '.';
            } else {
                return false;
            }
        }
    }
    return false;
}
 
int main() {
    int height, width, x, y, t;
    cin >> height >> width >> x >> y >> t;
    string map[height];
    for (int i = 0; i < height; i++) {
        cin >> map[i];
    }
 
    pos f;
    f.x = x - 1;
    f.y = y - 1;
    f.t = 0;
    queue<pos> q;
    q.push(f);
    map[x][y] = '.';
 
    while (q.size()) {
        pos n = q.front();
        q.pop();
        if (n.t >= t) {
            continue;
        }
 
        if (check_pos(height, width, (n.x + 1), (n.y + 1), n.t, map, q)) {
            cout << "S";
            return 0;
        } else if (check_pos(height, width, (n.x - 1), (n.y - 1), n.t, map, q)) {
            cout << "S";
            return 0;
        } else if (check_pos(height, width, (n.x + 1), (n.y - 1), n.t, map, q)) {
            cout << "S";
            return 0;
        } else if (check_pos(height, width, (n.x - 1), (n.y + 1), n.t, map, q)) {
            cout << "S";
            return 0;
        } else if (check_pos(height, width, (n.x + 1), n.y, n.t, map, q)) {
            cout << "S";
            return 0;
        } else if (check_pos(height, width, (n.x - 1), n.y, n.t, map, q)) {
            cout << "S";
            return 0;
        } else if (check_pos(height, width, n.x, (n.y + 1), n.t, map, q)) {
            cout << "S";
            return 0;
        } else if (check_pos(height, width, n.x, (n.y - 1), n.t, map, q)) {
            cout << "S";
            return 0;
        }
         
    }
    cout << "F";
 
    return 0;
}