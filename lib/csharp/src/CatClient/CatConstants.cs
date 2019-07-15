﻿using System;
using System.Collections.Generic;
using System.Runtime.InteropServices;
using System.Text;

namespace Org.Unidal.Cat
{
    public class CatConstants
    {
        public const String SUCCESS = "0";
        public const String UNKNOWN_DOMAIN = "Unknown";
        public const String LOCAL_CLIENT_CONFIG = "LocalClientConfig";
        public const String NULL_STRING = "null";

        /**
         * CAT client internal constants
         */
        public const String CAT_CONTEXT = "CatContext";
        public const String ID_MARK_FILE_MAP = "CatMarkFileMap";
        public const int ID_MARK_FILE_SIZE = 20;
        public const int ID_MARK_FILE_INDEX_OFFSET = 0;
        public const int ID_MARK_FILE_TS_OFFSET = 4;
        public const int ID_MARK_FILE_FLUSH_RATE = 1000;

        public const int HEARTBEAT_MIN_INITIAL_SLEEP_MILLISECONDS = 10000;
        public const int HEARTBEAT_MAX_INITIAL_SLEEP_MILLISECONDS = 60000;

        public const string DUMP_LOCKED = "dumpLocked";

        public const int TAGGED_TRANSACTION_CACHE_SIZE = 1024;

        // Prod
        public const int REFRESH_ROUTER_CONFIG_INTERVAL = 3600 * 1000;
        public const int TCP_RECONNECT_INTERVAL = 300 * 1000;
        public const int TCP_REBALANCE_INTERVAL = 600 * 1000;
        public const int TCP_CHECK_INTERVAL = 60000;
#if !NETSTANDARD
        public const string CAT_FILE_DIR = @"D:\data\appdatas\cat";
#else
        public readonly static string CAT_FILE_DIR = RuntimeInformation.IsOSPlatform(OSPlatform.Linux) ? @"/data/appdatas/cat" : @"D:\data\appdatas\cat";        
#endif

        /**
         * Remote call context info 
         */
        public const String ROOT_MESSAGE_ID = "RootMessageId";
        public const String CURRENT_MESSAGE_ID = "CurrentMessageId";
        public const String SERVER_MESSAGE_ID = "ServerMessageId";
        public const String CALL_APP = "CallApp";
        public const String TYPE_REMOTE_CALL = "RemoteCall";
        public const String NAME_REQUEST = "CallRequest";

        /**
         * LogEnable
         */
        public const String LOG_ENABLE = "LogEnabled";
        public const String CAT_HOME = @"D:\data\applogs";
        public const String CAT_HOME_TEMP = @"D:\data\applogs\cat";

        /**
        * Sql Event
       */
        public const string EVENT_SQL = "SQL";
        public const string EVENT_SQL_DATABASE = EVENT_SQL + ".Database";
        public const string EVENT_SQL_ROWS = EVENT_SQL + ".Rows";
        public const string EVENT_SQL_METHOD = EVENT_SQL + ".Method";

        /**
         * Redis Event
        */
        public const string EVENT_REDIS = "Redis";
        public const string EVENT_REDIS_SPEED = EVENT_REDIS + ".Speed";
        public const string EVENT_REDIS_SLOW = EVENT_REDIS + ".Slow";
        public const string EVENT_REDIS_LONG_KEY = EVENT_REDIS + ".LongKey";

        /**
         *  DurationRang
         */
        public readonly static List<KeyValuePair<long, String>> DURATION_LIST = new List<KeyValuePair<long, string>>
        {
            new KeyValuePair<long, string>(10,"0~10ms"),
            new KeyValuePair<long, string>(50,"10~50ms"),
            new KeyValuePair<long, string>(100,"50~100ms"),
            new KeyValuePair<long, string>(200,"100~200ms"),
            new KeyValuePair<long, string>(500,"200~500ms"),
            new KeyValuePair<long, string>(1000,"500ms~1s"),
            new KeyValuePair<long, string>(5000,"1~5s"),
            new KeyValuePair<long, string>(10000,"5~10s"),
            new KeyValuePair<long, string>(20000,"10~20s"),
            new KeyValuePair<long, string>(30000,"20~30s"),
            new KeyValuePair<long, string>(50000,"30~50s"),
            new KeyValuePair<long, string>(120000,"50~120s"),
            new KeyValuePair<long, string>(300000,"2~5m"),
            new KeyValuePair<long, string>(600000,"5~10m"),
        };
    }
}
