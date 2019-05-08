#
# @lc app=leetcode id=192 lang=bash
#
# [192] Word Frequency
#
# https://leetcode.com/problems/word-frequency/description/
#
# shell
# Medium (26.86%)
# Total Accepted:    18.4K
# Total Submissions: 68.4K
# Testcase Example:  'a'
#
# Write a bash script to calculate the frequency of each word in a text file
# words.txt.
#
# For simplicity sake, you may assume:
#
#
# words.txt contains only lowercase characters and space ' ' characters.
# Each word must consist of lowercase characters only.
# Words are separated by one or more whitespace characters.
#
#
# Example:
#
# Assume that words.txt has the following content:
#
#
# the day is sunny the the
# the sunny is is
#
#
# Your script should output the following, sorted by descending frequency:
#
#
# the 4
# is 3
# sunny 2
# day 1
#
#
# Note:
#
#
# Don't worry about handling ties, it is guaranteed that each word's frequency
# count is unique.
# Could you write it in one-line using Unix pipes?
#
#
#
# Read from the file words.txt and output the word frequency list to stdout.

# tr的s选项将多个替换的字符缩成1个，这里就是将多个空格缩减成1个
# 然后把空格替换为换行符，方便以后的排序
# sort就把一行行的文本排序
# uniq -c就把所有重复的做个统计
# sort -rg就把统计结果按照数字逆序排列
# 最后awk输出
# 要想理解，写个words文本文件，一个个命令的执行就可以看清了
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -rg | awk '{ print $2, $1 }'

