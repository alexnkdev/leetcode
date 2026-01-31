object Solution {
    def findLUSlength(a: String, b: String): Int = {
        if a == b then -1 else math.max(a.length(), b.length())
    }
}
