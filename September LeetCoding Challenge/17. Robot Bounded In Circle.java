/*

On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
*/

class Solution {
    public boolean isRobotBounded(String instructions) {
        int direction=0,x=0,y=0;
        for(int i=0;i<instructions.length();i++){
            char ch = instructions.charAt(i);
            switch(ch){
                case 'G':
                    if(direction==0)
                        y++;
                    else if(direction==1)
                        x--;
                    else if(direction==2)
                        y--;
                    else
                        x++;
                    break;
                case 'L':
                    direction = (direction+1)%4;
                    break;
                case 'R':
                    direction --;
                    if(direction<0)
                        direction=3;
                    break;
            }
        }
        return direction!=0||(x==0 && y==0);
    }
}
