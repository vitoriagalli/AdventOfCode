# Advent Of Code 2022 :christmas_tree::santa::gift:

This repo contains my solutions to [Advent of Code, 2022](https://adventofcode.com/2022) in clojure.

### Index

|                    Day                     |     Star      |               Src Code                |                     Test                      |
|:------------------------------------------:|:-------------:|:-------------------------------------:|:---------------------------------------------:|
| [01](https://adventofcode.com/2022/day/1)  | :star: :star: | [:page_facing_up:](src/aoc/day1.clj)  | [:white_check_mark:](test/aoc/day1_test.clj)  |
| [02](https://adventofcode.com/2022/day/2)  | :star: :star: | [:page_facing_up:](src/aoc/day2.clj)  | [:white_check_mark:](test/aoc/day2_test.clj)  |
| [03](https://adventofcode.com/2022/day/3)  | :star: :star: | [:page_facing_up:](src/aoc/day3.clj)  | [:white_check_mark:](test/aoc/day3_test.clj)  |
| [04](https://adventofcode.com/2022/day/4)  | :star: :star: | [:page_facing_up:](src/aoc/day4.clj)  | [:white_check_mark:](test/aoc/day4_test.clj)  |
| [05](https://adventofcode.com/2022/day/5)  |               | [:page_facing_up:](src/aoc/day5.clj)  | [:white_check_mark:](test/aoc/day5_test.clj)  |
| [06](https://adventofcode.com/2022/day/6)  |               | [:page_facing_up:](src/aoc/day6.clj)  | [:white_check_mark:](test/aoc/day6_test.clj)  |
| [07](https://adventofcode.com/2022/day/7)  |               | [:page_facing_up:](src/aoc/day7.clj)  | [:white_check_mark:](test/aoc/day7_test.clj)  |
| [08](https://adventofcode.com/2022/day/8)  |               | [:page_facing_up:](src/aoc/day8.clj)  | [:white_check_mark:](test/aoc/day8_test.clj)  |
| [09](https://adventofcode.com/2022/day/9)  |               | [:page_facing_up:](src/aoc/day9.clj)  | [:white_check_mark:](test/aoc/day9_test.clj)  |
| [10](https://adventofcode.com/2022/day/10) |               | [:page_facing_up:](src/aoc/day10.clj) | [:white_check_mark:](test/aoc/day10_test.clj) |
| [11](https://adventofcode.com/2022/day/11) |               | [:page_facing_up:](src/aoc/day11.clj) | [:white_check_mark:](test/aoc/day11_test.clj) |
| [12](https://adventofcode.com/2022/day/12) |               | [:page_facing_up:](src/aoc/day12.clj) | [:white_check_mark:](test/aoc/day12_test.clj) |
| [13](https://adventofcode.com/2022/day/13) |               | [:page_facing_up:](src/aoc/day13.clj) | [:white_check_mark:](test/aoc/day13_test.clj) |
| [14](https://adventofcode.com/2022/day/14) |               | [:page_facing_up:](src/aoc/day14.clj) | [:white_check_mark:](test/aoc/day14_test.clj) |
| [15](https://adventofcode.com/2022/day/15) |               | [:page_facing_up:](src/aoc/day15.clj) | [:white_check_mark:](test/aoc/day15_test.clj) |
| [16](https://adventofcode.com/2022/day/16) |               | [:page_facing_up:](src/aoc/day16.clj) | [:white_check_mark:](test/aoc/day16_test.clj) |
| [17](https://adventofcode.com/2022/day/17) |               | [:page_facing_up:](src/aoc/day17.clj) | [:white_check_mark:](test/aoc/day17_test.clj) |
| [18](https://adventofcode.com/2022/day/18) |               | [:page_facing_up:](src/aoc/day18.clj) | [:white_check_mark:](test/aoc/day18_test.clj) |
| [19](https://adventofcode.com/2022/day/19) |               | [:page_facing_up:](src/aoc/day19.clj) | [:white_check_mark:](test/aoc/day19_test.clj) |
| [20](https://adventofcode.com/2022/day/20) |               | [:page_facing_up:](src/aoc/day20.clj) | [:white_check_mark:](test/aoc/day20_test.clj) |
| [21](https://adventofcode.com/2022/day/21) |               | [:page_facing_up:](src/aoc/day21.clj) | [:white_check_mark:](test/aoc/day21_test.clj) |
| [22](https://adventofcode.com/2022/day/22) |               | [:page_facing_up:](src/aoc/day22.clj) | [:white_check_mark:](test/aoc/day22_test.clj) |
| [23](https://adventofcode.com/2022/day/23) |               | [:page_facing_up:](src/aoc/day23.clj) | [:white_check_mark:](test/aoc/day23_test.clj) |
| [24](https://adventofcode.com/2022/day/24) |               | [:page_facing_up:](src/aoc/day24.clj) | [:white_check_mark:](test/aoc/day24_test.clj) |
| [25](https://adventofcode.com/2022/day/25) |               | [:page_facing_up:](src/aoc/day25.clj) | [:white_check_mark:](test/aoc/day25_test.clj) |


### Prerequisites

- [Clojure](https://clojure.org/releases/downloads)
- [Leiningen](https://leiningen.org/)


### Usage

To run code

```bash
$ lein run
```

To run unit tests

```bash
$ lein test
```

### Options

`lein run {n-day} ..` to run only the chosen days

### Examples

```bash
$ lein run 1 2
$ ...
$ ---- day 1 ------
$ part 1:  66306
$ part 2:  195292
$ ---- day 2 ------
$ part 1:  12794
$ part 2:  14979
```

### License

Copyright © 2022 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
