
#!/usr/bin/env python3

def data_parser(filepath):
	tmp = open(filepath).read()
	return [line for line in tmp.split('\n') if line.strip() != '']

def check_slope(right, down, data):
	trees = 0
	column = 0
	line = 0
	while line < len(data):
		if data[line][column] == '#':
			trees += 1
		column = (column + right) % len(data[line])
		line += down
	return trees

def part_1(data):
	"""
	counting all the trees you would encounter for the slope right 3, down 1
	"""
	return print("part 1:", check_slope(3,1, data))

def multiply(slopes):
	product = 1
	for result in slopes:
		product *= result
	return print("part 2:", product)

def part_2(data):
	"""
	multiply together the number of trees encountered on each of the listed slopes
	"""
	slopes = []
	slopes.append(check_slope(1, 1, data))
	slopes.append(check_slope(3, 1, data))
	slopes.append(check_slope(5, 1, data))
	slopes.append(check_slope(7, 1, data))
	slopes.append(check_slope(1, 2, data))
	return multiply(slopes)

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()
