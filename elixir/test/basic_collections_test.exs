defmodule BasicCollectionsTest do
  use ExUnit.Case
  import Collections

  test "should double an array" do
    assert double_array([1, 2, 3, 4, 5]) == [2, 4, 6, 8, 10]
    assert double_array([5, 8, 12, 19, 22]) == [10, 16, 24, 38, 44]
  end

  test "should filter odds" do
    assert filter_odds([1,2,3,4,5]) == [1,3,5]
    assert filter_odds([3,4,5,6,7]) == [3,5,7]
    assert filter_odds([3,4,5,6,7,8,9]) == [3,5,7,9]
  end
end
