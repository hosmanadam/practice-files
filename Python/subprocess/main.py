import subprocess
import time


print('Python: Calling subprocess')
subprocess.call('sleep 2 && echo "Bash: Subprocess finished"', shell=True)
print('Python: Trying to print while subprocess is running')
time.sleep(4)
print('Python: Subprocess should be finished by now')
