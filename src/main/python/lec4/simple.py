#
# Task 1: Write a simple Higher Order Function map(data, f), where f() is some arith function and data is a List, Dictionary and Numpy array.
# map(data, f) applies function f() to every element of the data structure and returns a resulting data structure.
#
# Can you make a single implementation, Overloaded for all those 3 data structures? Assume datatype is Int.
# Which algorithmic complexity O(n) should it be? Will it depend on the underlying data structure?
#
#
import numpy as np
import builtins
from typing import overload, List


class Data:
    DEFAULT_INTS = 4, 6, 22, 3

    def __init__(self):
        self.list_data = [*self.DEFAULT_INTS]
        self.dict_data = {index: default_int for index, default_int in enumerate(self.DEFAULT_INTS)}
        self.np_data = np.array(self.DEFAULT_INTS)


@overload
def hof_func(data: list, operation: builtins = builtins.sum) -> List[int]:
    ...


@overload
def hof_func(data: dict, operation: builtins = builtins.sum) -> dict:
    ...


@overload
def hof_func(data: np.array, operation: builtins = builtins.sum) -> np.ndarray:
    ...


def hof_func(data, operation=sum):
    if isinstance(data, list):
        return list(map(operation, [data]))
    elif isinstance(data, np.ndarray):
        return np.array(list(map(operation, [data])))
    elif isinstance(data, dict):
        return dict(result=list(map(operation, [data.values()])))


def test_task_one():
    data_obj = Data()
    list_res = hof_func(data=data_obj.list_data)
    dict_res = hof_func(data=data_obj.dict_data)
    np_data_res = hof_func(data=data_obj.np_data)

    print('list:', list_res)
    print('dict:', dict_res)
    print('np_arr:', np_data_res)


if __name__ == '__main__':
    test_task_one()

# Task 2: Implement a speed optimized function for Task 1, the fastest you can. What algorithmic complexity O(n) should it be ?
