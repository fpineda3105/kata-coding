defmodule SquareDigits do
  require Integer

  @spec square_digits(integer) :: integer
  def square_digits(number) do
    Integer.digits(number)
    |> Enum.map(&(square(&1)))
    |> Enum.join()
    |> String.to_integer()
  end

  def square(digit) do
    digit * digit
  end

end
