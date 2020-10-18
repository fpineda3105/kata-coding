using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Text;
using Xunit;
using System.Linq;

namespace TrainigTDD
{
    /**
        https://www.codewars.com/kata/515decfd9dcfc23bb6000006
     * Write an algorithm that will identify valid IPv4 addresses in dot-decimal format. IPs should be considered valid if they consist of four octets, with values between 0 and 255, inclusive.

        Input to the function is guaranteed to be a single string.

        Examples
        Valid inputs:
            1.2.3.4
            123.45.67.89

        Invalid inputs:
            1.2.3
            1.2.3.4.5
            123.456.78.90
            123.045.067.089
     */
    public class IpValidationTest
    {
        [Fact]
        public void validate_correct_ips()
        {
            var validIps = new string[] { "192.168.0.1", "200.10.14.89", "137.255.156.100" };
            foreach (var ip in validIps)
            {
                Assert.True(IpValidation.validate(ip));
            }
        }

        [Fact]
        public void validate_incorrect_ips()
        {
            var invalidIps = new string[] { "12.34.56 .1", "", "192.068.0.1", "300.10.14.89", "192.131", "ass.123.123.123", "12.34.56.-1", "123.045.067.089", "12.34.56.78sf", "abc.def.ghi.jkl" };
            foreach (var ip in invalidIps)
            {
                Assert.False(IpValidation.validate(ip));
            }
        }

        private class IpValidation
        {
            internal static bool validate(string validIp)
            {
                string[] octets = validIp.Split('.');
                try
                {
                    return octets.Length == 4 && !octets.Any(num => ((num.StartsWith('0') && num.Length > 1) || num.Contains(" ") || int.Parse(num) < 0 || int.Parse(num) > 255));
                }
                catch (Exception)
                {
                    return false;
                }
            }
        }
    }
}
