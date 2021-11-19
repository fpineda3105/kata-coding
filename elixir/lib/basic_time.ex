defmodule TimeBasics do
  require Time

  def midnight_past(h, m, s) do
    midnight = Time.new!(0,0,0)
    after_midnight = Time.new!(h,m,s)
    Time.diff(after_midnight, midnight, :millisecond)
  end

end
