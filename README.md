# unique-int-sampler
Brief tool written in Java to sample a list of n integers between an upper and lower bound in O(n) time and space

- Uses Durstenfeld's version of the Fisher-Yates shuffle algorithm modified for the specific case where one is sampling from integers [a,b)
- Instead of inefficiently generating an array of ints from a to b - 1 taking up O((b - a) + n) space and time, uses a hashmap to store index mappings
