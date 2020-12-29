
#!/usr/bin/env python3

def data_parser(filepath):
	string = open(filepath).read()
	return sorted([int(line) for line in string.split('\n') if line])

def find_diff_voltage(data):
	all_diff = [data[0], 0, 1]
	for i, n in enumerate(data[:-1]):
		diff = data[i + 1] - data[i]
		all_diff[diff-1] += 1
	return all_diff[0] * all_diff[2]

def part_1(data):
	"""
	what is the number of 1-jolt differences multiplied by the number of 3-jolt differences?
	"""
	return print("part 1:", find_diff_voltage(data))

def count_distinct_ways(data, i, cache):
	if i in cache:
		return cache[i]
	cache[i] = sum([count_distinct_ways(data, i, cache) for i in range(i + 1, i + 4) if i in data])
	return cache[i]

def part_2(data):
	"""
	what is the total number of distinct ways you can arrange the adapters to
	connect the charging outlet to your device
	"""
	cache = {data[-1]: 1}
	count_distinct_ways(data, 0, cache)
	return print("part 2:", cache[0])

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()

