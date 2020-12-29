
#!/usr/bin/env python3
import re
import json
import string

def data_parser(filepath):
	'''
	convert file info (string) to dict.
	'''
	string = open(filepath).read()
	string = re.sub(r'[\n]', r' ', string)
	string = re.sub(r'([a-z]+):([#\da-z]+)', r'"\1" : "\2",', string)
	string = re.sub(r'[ ]+$', r' ', string)
	string = re.sub(r'[,][ ][ ]', r'}, {', string)
	string = re.sub(r'[,][ ]+$', r'}', string)
	string = '[{' + string + ']'
	data = json.loads(string)
	return data

def check_birth_year(value):
	return (1920 <= int(value) <= 2002)

def check_issue_year(value):
	return (2010 <= int(value) <= 2020)

def check_expiration_year(value):
	return (2020 <= int(value) <= 2030)

def check_height(value):
	unit = value[len(value)-2:]
	return ((unit == 'cm' and 150 <= int(value[:-2]) <= 193)
			or (unit == 'in' and 59 <= int(value[:-2]) <= 76))

def check_hair_color(value):
	return (len(value) == 7 and value[0] == '#'
			and all(c in string.hexdigits for c in value[1:]))

def check_eye_color(value):
	types = {'amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth'}
	return (value in types)

def check_passaport_id(value):
	return (len(value) == 9 and all(c in string.digits for c in value))

def required_fields(data):
	required_keys = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"}
	valid_passport = []
	for passport in data:
		if all(key in passport for key in required_keys):
			valid_passport.append(passport)
	return valid_passport

def valid_fields(data):
	valid_passport = []
	for passport in data:
		if all([check_birth_year(passport['byr']),
				check_issue_year(passport['iyr']),
				check_expiration_year(passport['eyr']),
				check_height(passport['hgt']),
				check_hair_color(passport['hcl']),
				check_eye_color(passport['ecl']),
				check_passaport_id(passport['pid'])]):
			valid_passport.append(passport)
	return valid_passport

def part_1(data):
	"""
	number of valid passports, those that have all required fields
	"""
	return print("part 1:", len(required_fields(data)))

def part_2(data):
	"""
	number of valid passports, those that have all required fields and valid values
	"""
	data = required_fields(data)
	data = valid_fields(data)
	valid_passport = data
	return print("part 2:", len(valid_passport))

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()
