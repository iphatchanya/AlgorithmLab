#include <iostream>
#include <queue>
 
using namespace std; 
 
typedef struct pos {
    int x, y, z;
    double t;
    vector<string> p;
} pos;
 
bool c = false;
 
bool check_pos(int w, int h, int d, int x, int y, int z, double t, pos cur, string map[], queue<pos> &q) {
    if (x >= 0 && x < w && y >= 0 && y < h && z > 0 && z <= d) {
        y = y + (z - 1) * h;
 
        if (map[y][x] == 'A') {
            pos n;
            n.x = x;
            n.y = y - (z - 1) * h;
            n.z = z;
            n.t = ++t;
            (cur.p).push_back(to_string(x + 1) + " " + to_string(n.y + 1) + " " + to_string(n.z));
            (n.p).insert((n.p).end(), (cur.p).begin(), (cur.p).end());
 
            for (auto i : (n.p)) {
                cout << i << "\n";
            }
            printf("%.2f", n.t/4);
 
            c = true;
            return true;
        } else if (map[y][x] != 'O') {
            return false;
        } else {
            pos tmp;
            tmp.x = x;
            tmp.y = y - (z - 1) * h;
            tmp.z = z;
            (cur.p).push_back(to_string(x+1) + " " + to_string(tmp.y + 1) + " " + to_string(tmp.z));
            (tmp.p).insert((tmp.p).end(), (cur.p).begin(), (cur.p).end());
            tmp.t = ++t;
            q.push(tmp);
 
            map[y][x] = '.';
        }
        return false;
    }
    return false;
}
 
int main() {
    int w, h, d, x, y, z;
    cin >> w >> h >> d;
    cin >> x >> y >> z;
 
    string map[h * d];
    for (int i = 0; i < h * d; i++) {
        cin >> map[i];
    }
 
    pos f;
    f.x = x - 1;
    f.y = y - 1;
    f.z = z;
    f.t = 0;
    (f.p).push_back(to_string(x) + " " + to_string(y) + " " + to_string(z));
     
    queue<pos> q;
    q.push(f);
     
    map[x - 1][y - 1] = '.';
 
    while (q.size()) {
        pos n = q.front();
        if (c) {
            continue;
        }
        q.pop();
 
        if (check_pos(w, h, d, n.x - 1, n.y - 1, n.z, n.t, n, map, q) || 
            check_pos(w, h, d, n.x, n.y - 1, n.z, n.t, n, map, q) ||
            check_pos(w, h, d, n.x + 1, n.y - 1, n.z, n.t, n, map, q) ||
            check_pos(w, h, d, n.x - 1, n.y, n.z, n.t, n, map, q) ||
            check_pos(w, h, d, n.x + 1, n.y, n.z, n.t, n, map, q) ||
            check_pos(w, h, d, n.x - 1, n.y + 1, n.z, n.t, n, map, q) ||
            check_pos(w, h, d, n.x, n.y + 1, n.z, n.t, n, map, q) ||
            check_pos(w, h, d, n.x + 1, n.y + 1, n.z, n.t, n, map, q) ||
            check_pos(w, h, d, n.x, n.y, n.z + 1, n.t, n, map, q) ||
            check_pos(w, h, d, n.x, n.y, n.z - 1, n.t, n, map, q)) {
            break;
        }
    }
}