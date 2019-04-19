import traceback

def string_multiplier(original: str, multiplier: int) -> str:
    name = traceback.extract_stack(None, 2)[0][-1]
    print(f"\n'{name}' expecting arguments of type '{string_multiplier.__annotations__['original']}' and '{string_multiplier.__annotations__['multiplier']}'\n")
    result: str = original * multiplier
    return result

tester: str = "I'm a string"
print(f"\n{__name__} will call string_multiplier() with parameter of type {__annotations__['tester']}\n")

print(string_multiplier(tester, 6), '\n')
