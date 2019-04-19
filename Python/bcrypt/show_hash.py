import bcrypt


password = bytes(input('Enter new password please: '), 'utf-8')
password_hash = bcrypt.hashpw(password, bcrypt.gensalt())
print('Your hash:', password_hash, sep='\n')
