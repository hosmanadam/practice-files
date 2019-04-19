"""Try running this from both . and .. as working directory"""

import os

print(os.getcwd())
print(__file__)
print(os.path.dirname(__file__))
print(os.path.abspath(__file__))
print(os.path.relpath(__file__))
