
#!/usr/bin/env python3

def data_parser(filepath):
	tmp = open(filepath).read().split()
	return [int(x) for x in tmp]

def part_1(data):
	"""
	Multiplying the two entries that sum to 2020
	"""
	for i, x in enumerate(data):
		for j, y in enumerate(data[i+1:]):
			if x + y == 2020:
				return print("part 1:", x * y)

def part_2(data):
	"""
	Multiplying the three entries that sum to 2020
	"""
	for i, x in enumerate(data):
		for j, y in enumerate(data[i+1:]):
			for k, z in enumerate(data[j+1:]):
				if x + y + z == 2020:
					return print("part 2:", x * y * z)

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()
