defmodule BasicCollectionsTest do
  use ExUnit.Case
  import Collections, only: [double_array: 1]

  test "should double an array" do
    assert double_array([1, 2, 3, 4, 5]) == [2, 4, 6, 8, 10]
    assert double_array([5, 8, 12, 19, 22]) == [10, 16, 24, 38, 44]
  end
end
