/*
Problem: Binary Watch
Problem No: 401
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Bit Manipulation
- Backtracking (Conceptually)
- Enumeration

------------------------------------------------
Problem Statement:
------------------------------------------------
A binary watch has:
- 4 LEDs for hours (0–11)
- 6 LEDs for minutes (0–59)

Given an integer turnedOn, return all possible times
where exactly turnedOn LEDs are ON.

Rules:
- Hour must not contain leading zero.
- Minute must always be 2 digits.

------------------------------------------------
Key Idea:
------------------------------------------------
1. Iterate through all possible hours (0–11).
2. Iterate through all possible minutes (0–59).
3. Count total ON bits using Integer.bitCount().
4. If total bits == turnedOn → valid time.
5. Format minute properly with leading zero if needed.

------------------------------------------------
Time Complexity:
------------------------------------------------
O(12 × 60) = O(720) → Constant time

------------------------------------------------
Space Complexity:
------------------------------------------------
O(1) excluding output list

------------------------------------------------
*/
class Solution {

    public List<String> readBinaryWatch(int turnedOn) {

        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {

                    // Format minute with leading zero
                    String time = hour + ":" + (minute < 10 ? "0" + minute : minute);
                    result.add(time);
                }
            }
        }

        return result;
    }
}
