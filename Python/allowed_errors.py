ALLOWED_ERRORS = (KeyboardInterrupt, SystemExit, ZeroDivisionError)


def foo():
    while True:
        try:
            # try ZeroDivisionError, TypeError, etc.
            var = eval(input('\nType bad expression to raise exception: '))
            print(f'  → No error: expression evaluates to \"{var}\"\n')
        except ALLOWED_ERRORS as err:
            print(f'  → Raising error: \"{err}\"\n')
            raise
        except BaseException as err:
            print(f'  → Handled error: \"{err}\"\n')


def main():
    print('\nAllowed errors: ', *ALLOWED_ERRORS, sep='\n  - ')
    foo()

if __name__ == '__main__':
    main()
