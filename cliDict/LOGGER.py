import logging
    
class SingleTon(object):
    def __new__(cls):
        if not hasattr(cls, 'instance'):
            cls.instance = super(SingleTon, cls).__new__(cls)
        return cls.instance

class LogManager(SingleTon):
    def __init__(self):
        self.logger = logging.getLogger()
        handler = logging.FileHandler('dict_log.txt', 'a')
        self.logger.setLevel(logging.DEBUG)
        log_format = logging.Formatter("[%(asctime)s] (%(name)s) %(levelname)s: %(message)s")
        handler.setFormatter(log_format)
        self.logger.addHandler(handler)
        super().__init__()
    
    def error(self, loggername, msg):
        self.logger = logging.getLogger(loggername)
        self.logger.error(msg)

    def warning(self, loggername, msg):
        self.logger = logging.getLogger(loggername)
        self.logger.warning(msg)

    def info(self, loggername, msg):
        self.logger = logging.getLogger(loggername)
        self.logger.info(msg)

class Logger(object):
    def __init__(self, loggername="ROOT"):
        self.log_manager = LogManager()
        self.loggername = loggername

    def error(self, msg):
        self.log_manager.error(self.loggername, msg)

    def warning(self, msg):
        self.log_manager.warning(self.loggername, msg)

    def info(self, msg):
        self.log_manager.info(self.loggername, msg)