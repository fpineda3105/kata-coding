defmodule SquareDigitsTest do
  use ExUnit.Case
  import SquareDigits

  test "sqare digits of 9119 should return 811181" do
      assert square_digits(9119) == 811181
  end

end
