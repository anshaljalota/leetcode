/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.
*/
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int row = image.size();
        if(row==0)
            return image;
        int col = image[0].size();
        if(col==0)
            return image;
        vector<vector<bool>> visited (row,vector<bool>(col,false));
        int oldColor = image[sr][sc];
        util(image,sr,sc,row,col,oldColor,newColor,visited);
        return image;
    }
    void util(vector<vector<int>>& image, int x, int y, int row, int col,int oldColor, int newColor,vector<vector<bool>>& visited){
        if(x<0||x>=row||y<0||y>=col||visited[x][y])
            return;
        visited[x][y]=true;
        if(image[x][y]!=oldColor)
            return;
        else{
            
            image[x][y]=newColor;
            util(image,x+1,y,row,col,oldColor,newColor,visited);
            util(image,x-1,y,row,col,oldColor,newColor,visited);
            util(image,x,y+1,row,col,oldColor,newColor,visited);
            util(image,x,y-1,row,col,oldColor,newColor,visited);
        }
    }
};
