namespace Omnium.Core
{
    public static class NumberWheel
    {
        private static int next = 1;

        public static int Next()
        {
            return next++;
        }
    }
}