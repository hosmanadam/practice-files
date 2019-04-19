from main import add_nums


class TestFunctions():

    def test1(self):
        assert add_nums(1, 2, 3, 4, 5) == 15


def test2():
    assert add_nums(1, 2, 4, 4, 6) == 17
