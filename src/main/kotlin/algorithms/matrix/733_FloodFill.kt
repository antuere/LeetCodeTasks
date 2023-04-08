package algorithms.matrix

/*
An image is represented by an m x n integer
grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color.
You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel,
plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) ,
all pixels connected by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
*/

fun main() {
    floodFill(
        image = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1)),
        sr = 1,
        sc = 1,
        color = 2
    )
}

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val startColor = image[sr][sc]
    if (startColor != color) {
        dfs(image, sr, sc, color, startColor)
    }

    image.forEach {
        println(it.toList())
    }
    return image

}

fun dfs(image: Array<IntArray>, r: Int, c: Int, color: Int, startColor: Int) {
    if (image[r][c] == startColor) {
        image[r][c] = color

        if (r - 1 >= 0) dfs(image, r - 1, c, color, startColor)
        if (r + 1 < image.size) dfs(image, r + 1, c, color, startColor)
        if (c - 1 >= 0) dfs(image, r, c - 1, color, startColor)
        if (c + 1 < image[0].size) dfs(image, r, c + 1, color, startColor)
    }
}