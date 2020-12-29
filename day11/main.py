
#!/usr/bin/env python3

def data_parser(filepath):
	string = open(filepath).read()
	return [line for line in string.split('\n') if line]

def create_empty_matrix(w, h):
	return [[0 for x in range(w)] for y in range(h)]

def check_adj(deltax, deltay, x, y, m):
	while x in range(0,len(m)) and y in range(0,len(m[x])):
		if m[x][y] == '.':
			x += deltax
			y += deltay
		else:
			return(m[x][y])
	return []

def neighbours(m, i, j, part):
	neighbours = []
	for x in [i-1, i, i+1]:
		for y in [j-1, j, j+1]:
			if x in range(0,len(m)) and y in range(0,len(m[x])) and (x,y) != (i,j):
				if part == 1:
					neighbours.append(m[x][y])
				else:
					neighbours.append(check_adj(x - i, y - j, x, y, m))
	return neighbours

def apply_rounds(cur_state, nmax, part):
	new_state = create_empty_matrix(len(cur_state[0]),len(cur_state))
	for i, seat in enumerate(new_state):
		for j, seat in enumerate(new_state[i]):
			if cur_state[i][j] == '.':
				new_state[i][j] = cur_state[i][j]
			else:
				occupied_adj_seats = neighbours(cur_state, i, j, part).count('#')
				if cur_state[i][j] == 'L' and not occupied_adj_seats:
					new_state[i][j] = '#'
				elif cur_state[i][j] == '#' and occupied_adj_seats >= nmax:
					new_state[i][j] = 'L'
				else:
					new_state[i][j] = cur_state[i][j]
	return(new_state)

def simulate_change_of_seats(cur_state, part, nmax):
	while True:
		new_state = apply_rounds(cur_state, nmax, part)
		if new_state == cur_state:
			break
		cur_state = new_state
	return sum([cur_state[i].count('#') for i, char in enumerate(cur_state)])

def part_1(data):
	"""
	how many seats end up occupied, checking only adjacent seats
	"""
	return print("part 1:", simulate_change_of_seats(data, 1, 4))

def part_2(data):
	"""
	how many seats end up occupied, checking all directions of adjacent seats
	"""
	return print("part 2:",  simulate_change_of_seats(data, 2, 5))

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()

