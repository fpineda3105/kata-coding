defmodule SumOfOddTriangleTest do
  use ExUnit.Case
  import SumOfOddTriangleLine, only: [row_sum_odd_numbers: 1]

  test "Shuld work for basic cases" do
    assert row_sum_odd_numbers(1) == 1
    assert row_sum_odd_numbers(2) == 8
    assert row_sum_odd_numbers(3) == 27
  end

  test "should return 2197 for number 13" do
    assert row_sum_odd_numbers(13) == 2197
  end

  test "should return 68921 for the line number 41" do
    assert row_sum_odd_numbers(41) == 68921
  end

end
