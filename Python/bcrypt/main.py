import bcrypt
from getpass import getpass


print('★ ★ ★ ★ ★ REGISTRATION ★ ★ ★ ★ ★')

# Create password
password1 = bytes(getpass('Enter new password please: '), 'utf-8')

# Hash a password for the first time, with a randomly-generated salt
password_hash1 = bcrypt.hashpw(password1, bcrypt.gensalt())


print('★ ★ ★ ★ ★ ★ LOGIN ★ ★ ★ ★ ★ ★')

# Get login attempt
password2 = bytes(getpass('Enter your password please: '), 'utf-8')

# Check that an unhashed password matches one that has previously been hashed
if bcrypt.checkpw(password2, password_hash1):
    print("It Matches!")
else:
    print("It Does not Match :(")
