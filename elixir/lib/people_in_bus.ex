defmodule PeopleInBus do

  def people_after_stops([]), do: 0

  def people_after_stops(stops) do
    stops
    |> Enum.map(&count_people_at_stop/1)
    |> Enum.sum()
  end

  defp count_people_at_stop({people_in, people_out}) do
    people_in - people_out
  end

end
